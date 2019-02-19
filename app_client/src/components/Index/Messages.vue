<template>
  <div>
      <div class="">
          <div class="chat_container">
              <div class="col-sm-3 chat_sidebar">
                  <div class="row">
                      <div id="custom-search-input">
                          <div class="input-group col-md-12">
                              <input type="text" class="  search-query form-control" placeholder="Conversation">
                              <button class="btn btn-danger" type="button">
                                  <span class=" glyphicon glyphicon-search"></span>
                              </button>
                          </div>
                      </div>
                      <div class="dropdown all_conversation">
                          <button class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                   <div><strong>Message details:</strong></div>
                          </button>
                          <div>
                            <pre>
                              {{ inspectedMessage }}
                            </pre>
                          </div>
                          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                              <li><a href="#"> All Conversation </a>
                                  <ul class="sub_menu_ list-unstyled">
                                      <li><a href="#"> All Conversation </a> </li>
                                      <li><a href="#">Another action</a></li>
                                      <li><a href="#">Something else here</a></li>
                                      <li><a href="#">Separated link</a></li>
                                  </ul>
                              </li>
                              <li><a href="#">Another action</a></li>
                              <li><a href="#">Something else here</a></li>
                              <li><a href="#">Separated link</a></li>
                          </ul>
                      </div>
                  </div>
              </div>
              <!--chat_sidebar-->

              <div class="col-sm-9 message_section">
                  <div class="row">
                      <div class="new_message_head">
                          <div class="col-md-12">
                              <div class="pull-left">
                                  <button><i class="fa fa-plus-square-o" aria-hidden="true"></i> New Message</button>
                              </div>
                              <div class="pull-right">
                                  <div class="dropdown">
                                      <button class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                          <i class="fa fa-cogs" aria-hidden="true"></i> Setting
                                          <span class="caret"></span>
                                      </button>
                                      <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                          <li><a href="#">Action</a></li>
                                          <li><a href="#">Profile</a></li>
                                          <li><a href="#">Logout</a></li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <!--new_message_head-->
                      <div class="chat_area">
                          <ul class="list-unstyled">
                              <li v-if="!message.isDeleted" class="left clearfix admin-chat" v-for="(message, index) in messages">
                                  <span class="chat-img1 pull-left"  >
                                   <img src="https://banner2.kisspng.com/20180630/ltq/kisspng-computer-icons-user-avatar-clip-art-skincare-cartoon-5b371025a6d8a7.5354815915303352696834.jpg" alt="User Avatar" class="img-circle">
                                   </span>
                                      <div class="chat-body1 clearfix">
                                          <p>{{message.content}}</p>
                                          <div class="text-danger pull-left" v-if="isPalindrome(message.content)">
                                            <strong>Is Palindrome</strong>
                                          </div>
                                          <div class="chat_time pull-right">
                                            <button class="btn btn-primary"
                                                  v-on:click="toggleMessageDetailsVisible(message)" >
                                              View Message Details
                                            </button>
                                            <button class="btn btn-danger"
                                                  v-on:click="deleteMessage(message.messageId)" >
                                                  Delete Message
                                            </button>
                                          </div>
                                      </div>
                              </li>
                              <li v-else >Deleted 😢 (Id: {{message.messageId }})</li>
                              <li class="left clearfix admin_chat">
                                  <span class="chat-img1 pull-right">
                           <img src="https://dumagueteinfo.com/classifieds/rentals/app/uploads/2017/03/user.png" alt="User Avatar" class="img-circle">
                           </span>
                                  <div class="chat-body1 clearfix">
                                      <p>Hi I am the other spy.</p>
                                  </div>
                              </li>

                          </ul>
                      </div>
                      <!--chat_area-->
                      <div class="message_write">
                          <textarea class="form-control" v-model="messageBody" v-on:keyup.enter="sendMessage()" placeholder="type a message"></textarea>
                          <div class="clearfix"></div>
                          <div class="chat_bottom"><a href="#" class="pull-left upload_btn"><i class="fa fa-cloud-upload" aria-hidden="true"></i>
       Add Files</a>
                              <a href="#" class="pull-right btn btn-success" v-on:click="sendMessage()">
       Send</a></div>
                      </div>
                  </div>
              </div>
              <!--message_section-->
          </div>
      </div>

  </div>
</template>

<script>
import api from '@API';
import './Messages.scss';

export default {
  name: 'Messages',
  data() {
    return {
      senderId: 'b9d8b3e0-2c1e-4560-823a-c9ce651dd7a2',
      recipientId: '717f7c2b-9e9d-463b-872a-170031c8dbed',
      messageBody: 'Hi there',
      messages: [],
      inspectedMessage: null
    };
  },
  created() {
    this.init();
  },
  methods: {
    init () {
      this.getMessages();
    },
    deleteMessage(messageId) {
      api.delete(`/v1/messages/${messageId}`)
      .then(response => {
        alert(`Message deleted ${messageId}.`)
        this.init();
      });
    },
    toggleMessageDetailsVisible (message) {
      api.get(`/v1/messages/${message.messageId}`)
      .then(response => {
          this.inspectedMessage = response.data;
      });
    },
    getMessages () {
        api.get(`/v1/messages/sender/${this.senderId}/receiver/${this.recipientId}`)
        .then(response => {
          this.messages = response.data.map((item) =>  {
              return {
                content: item.content,
                detailsVisible: false,
                isDeleted: item.isDeleted,
                messageId: item.messageId,
                recipientId: item.recipientId,
                senderId: item.senderId
              }
          });
        });
    },
    sendMessage () {
        api.post(`/v1/messages`,{
          "senderId": this.senderId,
          "recipientId": this.recipientId,
          "body": this.messageBody
        })
        .then(response => {
          this.init();
        })
    },
    isPalindrome (str) {
        var re = /[^A-Za-z0-9]/g;
        str = str.toLowerCase().replace(re, '');
        var len = str.length;
        for (var i = 0; i < len / 2; i++) {
            if (str[i] !== str[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
  },
};

</script>
