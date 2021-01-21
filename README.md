# Mask Messenger #

Mask Messenger is a messaging app focused on protecting the confidentiality and integrity of the data ("masking" the data, lol) exchanged between users. By using encryption techniques we assure the data is exchanged safely between users, minimizing the risk of a third party eavesdropping on the chatRoom. (This is the goal, now let's keep working to get there).

I'll be updating the progress on a separate file that I'll link later on.

The following are the original functionalities I wanted to implement. But I'll probably adapt them, and simplify them at the beginning to the development phase.

### App Functionalities
* User must be able to log in himself.
  * The system must be able to store login data in a secure manner.
  * The user can enter his login details in the app.
  * The app can verify the login details.
  * The system will notify the user after a few incorrect login attempts that someone (a specific IP address) wants to log into their account.
  * After a successful login, the user will be redirected to the "homepage".
    * The user has a local database in which messages are downloaded and stored.
    * The local database is encrypted
    * The local database is periodically synchronized with the cloud.

* Users can add, delete, process contacts.
  * The app must keep contact information of the user in a safe way.
  * The app will have a local database (or in the cloud, not sure yet how this should be best implemented) that stores the user's contacts.
  * User can create, read, edit and delete contacts (CRUD operations)

* The users communicate with each other via messages that are secured via encription.
  * Messages are encrypted.
  * The encrypted message is forwarded to the database.
  * Once the receiver is online, the receiver asks for the messages intended for it.
  * The receiver gets its messages.
  * The messages are desencrypted to plaintext.
  * The receiver can read the messages.

- Users can forward files that will also be protected.
  * Files are encrypted.
  * The encrypted files are forwarded to the database.
  * The receiver will receive the encrypted file.
  * The file is desencrypted by the app.
  * The original file will be saved in the receiver's memory.

* You can create groups with multiple users (but to add someone to a group you must have his permission).
  * The user chooses several contacts to create a group together.
  * A "compound" contact is created for each contact in the group, which has a reference to the other contacts (see last point).

* If the user wants, he can have the message deleted x number of seconds / minutes / ... after the reading moment.
  * The sender chooses an option to have messages deleted.
  * The sender writes the message and forwards it.
  * The receiver will receive the message with a timer next to the message.
  * Once the timer is at 0, the message is deleted (from the receiver's local DB, from the sender's local DB, at the cloud it is deleted once the receiver gets the message).


* About the database:
  * Nothing is kept in the cloud if it is not needed:
    * The DB gets the messages from the sender and words are kept there until the receiver gets the message, then it is deleted in the cloud (the system checks that the receiver got it to make sure that is the case).
      * If the user wants to delete the app and still keep the messages:
        * It can forward a copy of the local DB to the cloud.
        * The next time this user logs in to the app himself / herself, he will be asked if he wants to download the entire DB or just the contacts.
        * If he wants to download the DB, a copy is downloaded to the user's device.
        * If he chooses to download only the contacts, only the contacts are saved.
        * If he doesn't want that, the cloud copy is deleted and the user starts his account from scratch.
  * In order to guarantee the privacy of the users, no personal data is stored:
    * Each user has a UUID that is known only in the database, to know what to forward to whom.
    * The messages (for the little time they are in the database) are fully encrypted.
  * The file send system works like the messages: once the receiver gets the file, it is deleted from the DB.

* (Optional if I still have the time and energy to do so) Scripted voice / video calls.
  * We'll see about this in the future :)
