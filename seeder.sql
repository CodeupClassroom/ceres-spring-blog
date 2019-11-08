use ceres_blog_db;

# Seed users

insert into users (username, email, password) values ('bob123', 'bob@email.com', 'password');

# Seed ads

insert into ads (title, description, user_id) values 
                                                     ('Ad 1', 'A good thing 1', 1),
                                                     ('Ad 2', 'A good thing 2', 1),
                                                     ('Ad 3', 'A good thing 3', 1);

