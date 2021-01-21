create table users(
    id_bin_user binary(16), #This column will contain the binary value o the id.
    name varchar(200),
    password varchar(200));

create table saved_conversations(
    id_bin_conversation binary(16), #This column will contain the binary value o the id.
    interlocutor1_id binary(16),
    interlocutor2_id binary(16));
