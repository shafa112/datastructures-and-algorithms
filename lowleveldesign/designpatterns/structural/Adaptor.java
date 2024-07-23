package designpatterns.structural;

public class Adaptor {
    /*
    * Also, see shadab example on git
    *
    * v1.jar
    * SMSUtil
    *   send(...)
    *
    * v2.jar
    * WhatsApp
    *   push(...)
    * ---------------------------------------------------------------
    * Client uses only below code and doesn't have to include different jars everytime any new type of
    * message service is added. Instead, we will have Messenger interface and create classes for
    * new type of message service.
    *
    * Test client = getMessengerObject(...);
    * client.sendMessage()
    * ---------------------------------------------------------------
    * interface Messenger
    *   sendMessage()
    *
    * class SMSUtilMessenger implements Messenger
    *   sendMessage(){
    *       SMSUtil.send();
    *   }
    *
    * class WhatsAppMessenger implements Messenger
    *   sendMessage(){
    *       WhatsApp.push();
    *   }
    *
    * */
}
