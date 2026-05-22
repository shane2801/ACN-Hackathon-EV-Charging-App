const WebSocket = require("ws")

function createCharger(id) {
  const ws = new WebSocket(`ws://localhost:8080/ocpp/${id}`)

  let energy = 0
  let interval

  ws.on("open", () => {
    console.log(`${id} connected to backend`)

    ws.send(JSON.stringify({
      type: "BootNotification",
      chargerId: id
    }))

    // auto start charging after 3 sec
    setTimeout(() => startCharging(), 3000)
  })

  function startCharging() {
    console.log(`${id} START charging`)

    ws.send(JSON.stringify({
      type: "StartTransaction",
      chargerId: id
    }))

    interval = setInterval(() => {
      energy += Math.random() * 0.5

      ws.send(JSON.stringify({
        type: "MeterValues",
        chargerId: id,
        powerKw: 6 + Math.random() * 2,
        energyKwh: energy
      }))
    }, 2000)
  }

  ws.on("message", (msg) => {
    console.log(`${id} received:`, msg.toString())
  })

  ws.on("close", () => {
    clearInterval(interval)
  })
}

// simulate 2 chargers
createCharger("charger-001")
createCharger("charger-002")
createCharger("charger-101")