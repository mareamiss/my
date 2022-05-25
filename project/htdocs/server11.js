const express = require('express'),
http = require('http'),
port = process.env.PORT || 3000,
ip = process.env.IP || '192.168.1.113', //My IP address. I try to "127.0.0.1" but it the same => don't run
server = http.createServer().listen(port, ip, function () {
    console.log("IP = ", ip);
    console.log("start socket successfully");
});
app = express(),
// server = http.createServer(app),
io = require('socket.io').listen(server);
app.get('/', (req, res) => {

res.send('Chat Server is running on port 3000')
});
io.on('connection', (socket) => {

console.log('user connected')

socket.on('join', function(userNickname) {

        console.log(userNickname +" : has joined the chat "  );

        socket.broadcast.emit('userjoinedthechat',userNickname +" : has joined the chat ");
    });


socket.on('messagedetection', (senderNickname,messageContent) => {
       
       //log the message in console 

       console.log(senderNickname+" :" +messageContent)
        //create a message object 
       let  message = {"message":messageContent, "senderNickname":senderNickname}
          // send the message to the client side  
       io.emit('message', message );
     
      });
      
  
 socket.on('disconnect', function() {
    console.log( ' user has left ')
    socket.broadcast.emit("userdisconnect"," user has left ") 

});



});





server.listen(3000,()=>{

console.log('Node app is running on port 3000');

});
