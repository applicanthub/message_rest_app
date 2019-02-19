<template>
  <div class="app">
    <header>
       <nav class="navbar navbar-inverse">
           <div class="container">
               <!-- Brand and toggle get grouped for better mobile display -->
               <div class="navbar-header">
                   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                       <span class="sr-only">Toggle navigation</span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                   </button>
                   <a class="navbar-brand" href="#">Spy Chat</a>
               </div>
               <div class="collapse navbar-collapse" id="navbar-collapse-1">
                   <ul class="nav navbar-nav navbar-right">
                       <li>
                           <router-link :to="{name: 'Home' }">Home</router-link>
                       </li>
                   </ul>
                   <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse1">
                       <li><a href="#">Web design</a></li>
                       <li><a href="#">Development</a></li>
                       <li><a href="#">Graphic design</a></li>
                       <li><a href="#">Print</a></li>
                       <li><a href="#">Motion</a></li>
                       <li><a href="#">Mobile apps</a></li>
                   </ul>
               </div>
               <!-- /.navbar-collapse -->
           </div>
           <!-- /.container -->
       </nav>
   </header>
   <router-view />
</div>
</template>
<script>
export default {
  name: 'App',
  data() {
    return {

    };
  },
};
</script>
