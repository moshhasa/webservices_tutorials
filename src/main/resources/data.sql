insert into User (`id`, `name`, `date_of_birth`) values (1001, 'AB', sysdate());
insert into User (`id`, `name`, `date_of_birth`) values (1002, 'Jack', sysdate());
insert into User (`id`, `name`, `date_of_birth`) values (1003,'Jamie' , sysdate());

insert into Post (`id`, `content`, `author_id`) values (1001, 'this is Abs first post', 1001);
insert into Post  (`id`, `content`, `author_id`) values (1002, 'this is Jacks first post', 1002);
insert into Post  (`id`, `content`, `author_id`) values (1003,'this is  Jamies first post' , 1003);