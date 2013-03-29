Instructions
============

1. Modify address in SocketClient.java:

2. Modify port in SocketClient.java and SocketServer.java:

3. Go to src folder and compile the source codes:
<pre>
    javac -d .. test/*
</pre>
4. Go to root folder and run the program.
Server side:
<pre>
    java test.Main server
</pre>
Client side:
<pre>
    java test.Main client
</pre>
5. Type anything in client; messages will be sent to server and printed.

6. Type quit to stop client; Type Ctrl + C to stop server.
