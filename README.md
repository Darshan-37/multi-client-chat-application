# Multi-Client Chat Application

A real-time multi-client chat application built using Java Socket Programming, Multithreading, and Swing GUI. The application allows multiple users to connect to a server, exchange messages in real time, view online users, and send private messages.

## Features

- Real-time messaging
- Multi-client support
- Client-server architecture
- Java Swing graphical user interface
- Private messaging (`/msg`)
- Online users command (`/users`)
- User join and leave notifications
- Concurrent client handling using multithreading

## Technologies Used

- Java
- Java Sockets
- Multithreading
- Java Swing
- TCP/IP Networking
- Java Collections Framework

## Project Structure

```text
server.java
ClientHandler.java
ChatClientGUI.java
thread1.java
```

## How It Works

1. The server starts and listens for incoming client connections.
2. Each connected client is assigned a dedicated thread.
3. Users provide a username when joining.
4. Messages are broadcast to all connected users.
5. Private messages can be sent using commands.
6. Disconnected users are automatically removed from the active client list.

## Available Commands

### View Online Users

```text
/users
```

Displays the list of currently connected users.

### Send Private Message

```text
/msg username your message here
```

Example:

```text
/ msg john Hello!
```

## Running the Application

### Start the Server
Run:
```text
server.java
```

### Start Clients
Run:
```text
ChatClientGUI.java
```

Open multiple client instances to simulate multiple users.

## Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Socket Programming
- Multithreading
- Client-Server Architecture
- Event-Driven Programming
- Concurrent Communication

## Future Improvements

- Message timestamps
- Online users panel
- Chat rooms
- Message history
- File sharing
- User authentication
