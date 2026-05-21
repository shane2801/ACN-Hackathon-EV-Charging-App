import { useEffect, useState } from 'react'
import { getHealth } from './services/api'

function App() {
  const [message, setMessage] = useState('Loading...')

  useEffect(() => {
    getHealth()
      .then((data) => setMessage(data.message))
      .catch(() => setMessage('Backend connection failed'))
  }, [])

  return (
    <div style={{ padding: '40px', fontFamily: 'Arial' }}>
      <h1>EV Charging Platform</h1>

      <h2>{message}</h2>
    </div>
  )
}

export default App