package system._administration_tooling_twitter.scripts;

import twitter4j.*
import twitter4j.api.*
import twitter4j.auth.*
import twitter4j.conf.* 
import twitter4j.json.* 
import twitter4j.management.* 
import twitter4j.media.* 
import twitter4j.util.* 

def data = functionHelper.createDataObject("administration_tooling_twitter:OauthContext","none","")


 Twitter twitter = new TwitterFactory().getInstance();
 twitter.setOAuthConsumer(registry("Twitter.AppKey"),registry("Twitter.AppSecret"));
 RequestToken requestToken = twitter.getOAuthRequestToken();


data.set("client",twitter)
data.set("requestToken",requestToken)
data.set("oauthURL",requestToken.getAuthorizationURL())

return data