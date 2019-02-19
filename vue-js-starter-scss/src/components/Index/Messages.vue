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
                              <i class="fa fa-weixin" aria-hidden="true"></i> All Conversations
                          </button>
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
                      <div class="member_list">
                          <ul class="list-unstyled">

                              <li class="left clearfix" v-for="(message, index) in messages">
                                  <span class="chat-img pull-left">
                         <img src="https://store.playstation.com/store/api/chihiro/00_09_000/container/US/en/999/UP0937-CUSA05590_00-AV00000000000005/1520763129000/image?w=240&h=240&bg_color=000000&opacity=100&_version=00_09_000" alt="User Avatar" class="img-circle">
                         </span>
                                  <div class="chat-body clearfix">
                                      <div class="header_sec">
                                          <strong class="primary-font">Jack Sparrow</strong> <strong class="pull-right">
                               09:45AM</strong>
                                      </div>
                                      <div class="contact_sec">
                                          <strong class="primary-font">...</strong> <span class="badge pull-right">3</span>
                                      </div>
                                  </div>
                              </li>
                          </ul>
                      </div>
                  </div>
              </div>
              <!--chat_sidebar-->

              <div class="col-sm-9 message_section">
                  <div class="row">
                      <div class="new_message_head">
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
                      <!--new_message_head-->

                      <div class="chat_area">
                          <ul class="list-unstyled">

                              <li class="left clearfix admin-chat"  v-for="(message, index) in messages">
                                  <span class="chat-img1 pull-left">
                         <img src="https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg" alt="User Avatar" class="img-circle">
                         </span>
                                  <div class="chat-body1 clearfix">
                                      <p>{{message.content}}</p>
                                      <div
                                      class="text-danger pull-left"
                                      v-if="palindrome(message.content)"><strong>palindrome</strong> </div>
                                      <div class="chat_time pull-right">09:40PM</div>
                                  </div>
                              </li>
                              <li class="left clearfix admin_chat">
                                  <span class="chat-img1 pull-right">
                         <img src="https://lh6.googleusercontent.com/-y-MY2satK-E/AAAAAAAAAAI/AAAAAAAAAJU/ER_hFddBheQ/photo.jpg" alt="User Avatar" class="img-circle">
                         </span>
                                  <div class="chat-body1 clearfix">
                                      <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia.</p>
                                      <div class="chat_time pull-left">09:40PM</div>
                                  </div>
                              </li>

                          </ul>
                      </div>
                      <!--chat_area-->
                      <div class="message_write">
                          <textarea class="form-control" v-model="messageBody" placeholder="type a message"></textarea>
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
    };
  },
  created() {
    this.init();
  },
  methods: {
    init () {
      this.getMessages();
    },
    getMessages () {
        api.get(`/v1/messages/sender/${this.senderId}/receiver/${this.recipientId}`)
        .then(response => {
          this.messages = response.data;
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
    palindrome (str) {
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
