const API_BASE = 'http://localhost:8080/api'

export async function getHealth() {
  const response = await fetch(`${API_BASE}/health`)
  return response.json()
}