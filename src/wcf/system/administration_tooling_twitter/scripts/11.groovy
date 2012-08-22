package system._administration_tooling_twitter.scripts;
// The following are special reserved parameters which are always available to scripts (see documentation for details)
//
// resourceBundle - the java ResourceBundle for the current locale with strings loaded from the module's "strings.properties" file in the public directory
// specificTimeRange - the current specific time range that must be used to get property values from data objects
// functionHelper - the FunctionHelper instance for getting other information 
//
// Uncomment the following line to get a Log instance
// org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog("script." + functionHelper.getFunctionId());



import twitter4j.*
import twitter4j.api.*
import twitter4j.auth.*
import twitter4j.conf.* 
import twitter4j.json.* 
import twitter4j.management.* 
import twitter4j.media.* 
import twitter4j.util.* 


def TOKEN = ""

def twitter = oauthContext.get("client")
def requestToken = oauthContext.get("requestToken")

TOKEN = twitter.getOAuthAccessToken(requestToken, pin);

def saveVariable(String key, String value){
def var = server.RegistryService.editRegistryVariable(key)

def dv = var.createTopologyTypeRegistryValue("TopologyObject")
dv.setDefaultValue(value)
var.setGlobalDefault(dv)

server.RegistryService.saveRegistryVariable(var)
}

saveVariable("Twitter.ScreenName",TOKEN.getScreenName())
saveVariable("Twitter.ClientToken",TOKEN.getToken())
saveVariable("Twitter.ClientKey",TOKEN.getTokenSecret())
println TOKEN.getScreenName()
println TOKEN.getToken()
 println TOKEN.getTokenSecret()