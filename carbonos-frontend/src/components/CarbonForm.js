import React, { useState } from "react";
import { calculateCarbon } from "../services/api";

const CarbonForm = () => {
  const [activityType, setActivityType] = useState("");
  const [fuelType, setFuelType] = useState("");
  const [value, setValue] = useState("");
  const [result, setResult] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await calculateCarbon({
        activityType,
        fuelType,
        value: Number(value),
      });
      setResult(response.data);
    } catch (error) {
      alert("Error connecting to backend");
    }
  };

  return (
    <div className="card">
      <h2>🌱 Carbon Emission Calculator</h2>

      <form onSubmit={handleSubmit}>
        <input
          placeholder="Activity Type (e.g. TRANSPORT)"
          value={activityType}
          onChange={(e) => setActivityType(e.target.value)}
          required
        />

        <input
          placeholder="Fuel Type (diesel / petrol / electricity)"
          value={fuelType}
          onChange={(e) => setFuelType(e.target.value)}
          required
        />

        <input
          type="number"
          placeholder="Value (km / units)"
          value={value}
          onChange={(e) => setValue(e.target.value)}
          required
        />

        <button type="submit">Calculate</button>
      </form>

      {result && (
        <div className="result">
          <h3>📊 Result</h3>
          <p><b>Emission:</b> {result.emission} kg CO₂</p>
          <p><b>Fuel:</b> {result.fuelType}</p>
          <p><b>Activity:</b> {result.activityType}</p>
        </div>
      )}
    </div>
  );
};

export default CarbonForm;
