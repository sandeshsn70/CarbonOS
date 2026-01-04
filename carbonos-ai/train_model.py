import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import LabelEncoder
import joblib
import os

# -----------------------------
# CONFIG
# -----------------------------
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_PATH = os.path.join(BASE_DIR, "data.csv")
MODEL_PATH = os.path.join(BASE_DIR, "carbon_model.pkl")
ACTIVITY_ENCODER_PATH = os.path.join(BASE_DIR, "activity_encoder.pkl")
FUEL_ENCODER_PATH = os.path.join(BASE_DIR, "fuel_encoder.pkl")

# -----------------------------
# LOAD DATA
# -----------------------------
df = pd.read_csv(DATA_PATH)

required_columns = {"activity_type", "fuel_type", "value", "emission"}
if not required_columns.issubset(df.columns):
    raise ValueError(f"CSV must contain columns: {required_columns}")

# -----------------------------
# ENCODE CATEGORICAL DATA
# -----------------------------
activity_encoder = LabelEncoder()
fuel_encoder = LabelEncoder()

df["activity_type_enc"] = activity_encoder.fit_transform(df["activity_type"])
df["fuel_type_enc"] = fuel_encoder.fit_transform(df["fuel_type"])

# -----------------------------
# FEATURES & TARGET
# -----------------------------
X = df[["activity_type_enc", "fuel_type_enc", "value"]]
y = df["emission"]

# -----------------------------
# TRAIN MODEL
# -----------------------------
model = LinearRegression()
model.fit(X, y)

# -----------------------------
# SAVE MODEL & ENCODERS
# -----------------------------
joblib.dump(model, MODEL_PATH)
joblib.dump(activity_encoder, ACTIVITY_ENCODER_PATH)
joblib.dump(fuel_encoder, FUEL_ENCODER_PATH)

print("✅ ML model trained and saved successfully")
print(f"📦 Model: {MODEL_PATH}")
print(f"📦 Activity Encoder: {ACTIVITY_ENCODER_PATH}")
print(f"📦 Fuel Encoder: {FUEL_ENCODER_PATH}")
