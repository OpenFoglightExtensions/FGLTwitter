package system._administration_tooling_twitter_common.scripts;
// The following are special reserved parameters which are always available to scripts (see documentation for details)
//
// resourceBundle - the java ResourceBundle for the current locale with strings loaded from the module's "strings.properties" file in the public directory
// specificTimeRange - the current specific time range that must be used to get property values from data objects
// functionHelper - the FunctionHelper instance for getting other information 
//
// Uncomment the following line to get a Log instance
// org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog("script." + functionHelper.getFunctionId());

def twitter = getTwitterClient()
def followers = twitter.getFollowersIDs(-1).ids
def users = []
if (followers.size() >0 ) users = twitter.lookupUsers(followers)
return users.collect { u ->

def data = functionHelper.createDataObject("administration_tooling_twitter_common:User","none","")
data.set("name",u.name)
data.set("screenName",u.screenName)
data.set("id",u.id)

return data

}