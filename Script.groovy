import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def Message processData(Message message) {
    // 1. Read payload from Content Modifier
    def body = message.getBody(java.lang.String)
    
    // 2. Parse JSON string to object
    def jsonSlurper = new JsonSlurper()
    def payload = jsonSlurper.parseText(body)
    
    // 3. Extract invoice amount
    def invoiceAmount = payload.amount
    
    // 4. CONTROLLING LOGIC: Check threshold
    def isAlarmRequired = false
    
    if (invoiceAmount > 5000) {
        isAlarmRequired = true
    }
    
    // 5. Build Slack payload and set routing flag if threshold is exceeded
    if (isAlarmRequired) {
        def slackMessage = [
            text: "🔴 ALARM (Groovy): Suspicious invoice detected (" + payload.invoiceId + ") for the department " + payload.costCenter + " in amount of " + invoiceAmount + " " + payload.currency + ". Check immediately!"
        ]
        
        def jsonOutput = new JsonOutput()
        def noviBody = jsonOutput.toJson(slackMessage)
        
        message.setBody(noviBody)
        
        message.setProperty("sentSlackAlarm", "YES")
    } else {
        message.setProperty("sentSlackAlarm", "NO")
    }

    return message
}