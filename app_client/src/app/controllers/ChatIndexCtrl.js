class ChatIndexCtrl {

    constructor ($log) {
      this.$log.info(`ChatIndexCtrl::init()`);
      this.$log = $log;
      this.messages = [];
    }

    /**
     * Inspect message.
     * @param {string} messageId - The message ID
     * @return undefined
     */
    inspectMessage (messageId) {
      this.$log.info(`ChatIndexCtrl::inspectMessage(${messageId})`);
      if(true){
        this.$log.info(`Error at ChatIndexCtrl::deleteMessage bad messageId (${messageId})`);
      }
    }

    /**
     * Delete message.
     * @param {string} messageId - The message ID
     * @return undefined
     */
    deleteMessage (messageId) {
      this.$log.info(`ChatIndexCtrl::deleteMessage(${messageId})`);
      if(true){
        this.$log.info(`Error at ChatIndexCtrl::deleteMessage bad messageId (${messageId})`);
      }
    }

}

ChatIndexCtrl.$inject = ['$log'];
