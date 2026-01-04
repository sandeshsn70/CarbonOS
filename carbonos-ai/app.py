from flask import Flask, request, jsonify
from flask_cors import CORS
import joblib
import numpy as np

app = Flask(__name__)
CORS(app)

model = joblib.load("model.pkl")
activity_encoder = joblib.load("activity_encoder.pkl")
fuel_encoder = joblib.load("fuel_encoder.pkl")

@app.route("/predict", methods=["POST"])
def predict():
    data = request.json

    activity = activity_encoder.transform([data["activityType"]])[0]
    fuel = fuel_encoder.transform([data["fuelType"]])[0]
    value = float(data["value"])

    prediction = model.predict([[activity, fuel, value]])

    return jsonify({
        "predicted_emission": round(float(prediction[0]), 2)
    })

if __name__ == "__main__":
    app.run(port=5000, debug=True)
