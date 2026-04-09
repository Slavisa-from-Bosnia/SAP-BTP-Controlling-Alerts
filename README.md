# SAP-BTP-Controlling-Alerts
# 🚀 Real-Time Budget Control: SAP to Slack Integration

## 📌 Project Overview
In traditional enterprise environments, controlling departments often rely on end-of-month reporting to detect budget overruns. This reactive approach can lead to significant financial discrepancies. 

This project demonstrates a proactive, real-time solution built on **SAP Business Technology Platform (BTP)**. Using **SAP Integration Suite**, I developed an automated Integration Flow (iFlow) that intercepts high-value financial documents and instantly triggers targeted alerts in a corporate communication tool (Slack).

## 🛠️ Tech Stack
* **Platform:** SAP BTP (Business Technology Platform)
* **Integration Engine:** SAP Cloud Integration (Integration Suite)
* **API Management:** SAP Open Connectors
* **Logic/Scripting:** Groovy
* **Target System:** Slack API

---

## 🏗️ Architecture & Workflow

![Integration Flow Canvas]<img width="1920" height="1080" alt="Screenshot (1145)" src="https://github.com/user-attachments/assets/861ade0d-f928-409c-b896-e5bacda85d6d" />
*(Image: The complete Integration Flow deployed in SAP Cloud Integration)*

### How it works under the hood:
1. **Trigger:** A Timer initiates the process (simulating a scheduled fetch of new invoice records).
2. **Payload Generation:** A Content Modifier injects the JSON payload representing an incoming invoice (e.g., €7,500 for the MARKETING cost center).
3. **Business Logic (Groovy):** A custom Groovy script parses the payload, evaluates the total amount against the predefined business threshold (> €5,000), and sets a dynamic routing flag (`isAlarmRequired`). It also structures the final, user-friendly message.
4. **Conditional Routing:** A Router evaluates the flag. Routine invoices are terminated silently, while high-value anomalies are directed to the external API.
5. **Delivery:** The payload is pushed securely through **SAP Open Connectors** directly into the designated Slack channel.

---

## 🧠 The Brains: Groovy Scripting
Instead of relying solely on standard mapping blocks, I implemented the business validation logic using Groovy. This allows for complex evaluations and dynamic JSON restructuring on the fly.

![Groovy Script Snippet]<img width="1920" height="1080" alt="Screenshot (1153)" src="https://github.com/user-attachments/assets/765803ff-19f2-42a8-8eab-0656a7fb0c74" />

*(Image: Extracting values, applying controlling logic, and modifying properties)*

---

## 🎯 The Result: Real-Time Business Value
By bridging the gap between the ERP backend and modern team communication tools, budget owners are notified instantly about critical transactions, completely bypassing the reporting lag.

![Slack Alert Output]<img width="1920" height="1080" alt="Screenshot (1154)" src="https://github.com/user-attachments/assets/043c6721-4cab-4397-a2bd-0d871e79c1da" />

*(Image: The automated alert delivered to the #all-sap-test Slack channel)*

---
*Created as part of a comprehensive SAP BTP Developer portfolio focusing on Financial Automation.*
