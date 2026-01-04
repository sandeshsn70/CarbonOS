import React, { useState } from "react";

function App() {
  const [value, setValue] = useState("");
  const [actual, setActual] = useState(null);
  const [predicted, setPredicted] = useState(null);

  const handleCalculate = async () => {
    const payload = {
      activityType: "TRANSPORT",
      fuelType: "diesel",
      value: Number(value)
    };

    // 1️⃣ Call Spring Boot (Rule-based)
    const springRes = await fetch("http://localhost:8081/api/carbon/calculate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload)
    });
    const springData = await springRes.json();
    setActual(springData.emission);

    // 2️⃣ Call Flask (ML-based)
    const flaskRes = await fetch("http://localhost:5000/predict", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload)
    });
    const flaskData = await flaskRes.json();
    setPredicted(flaskData.predicted_emission);
  };

  return (
    <div style={{ padding: "30px" }}>
      <h1>CarbonOS 🌍</h1>
      <p>AI-based Carbon Emission Intelligence Platform</p>

      <input
        type="number"
        value={value}
        onChange={(e) => setValue(e.target.value)}
        placeholder="Enter value"
      />
      <br /><br />

      <button onClick={handleCalculate}>Calculate Emission</button>

      <h2>Results</h2>
      <p><b>Actual Emission (Rule-based):</b> {actual}</p>
      <p><b>Predicted Emission (ML):</b> {predicted}</p>
    </div>
  );
}

export default App;
