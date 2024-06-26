# Study_Sphere_Spring_BackEnd_Gradle
This is the gradle version of Study Sphere's backend

## Table of Contents
1. [Related Repositories](#Related-Repositories)
2. [Overview](#Overview)
3. [Product Spec](#Product-Spec)
4. [Wireframes](#Wireframes)

## Related Repositories
### Angular Front-end Developement
https://github.com/XiaoyangJin/Study_Sphere_Angular_FrontEnd.git
### Spring ios Developement
https://github.com/XiaoyangJin/StudySphere_web_ios

## Overview
### Description
This is an app where user can post their study progress and knowledge and view other's posts


### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Educational/Social Media
- **Browser:** Chrome, Firefox, Safari, Vivaldi
- **Story:** Encourages and helps users to study by posting their progress and viewing other's progress
- **Market:** Anyone loves study! Especially students at all levels
- **Habit:** As needed, but user receives notification to view/post progress everyday
- **Scope:** Broad, meets all users' needs

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
* User able to log in and log out
* User able to see a table view of other students' study logs
* User able to tap on cells in table view to see details of a study log item, which can include picutres and videos
* user able to see date when they post
* user able to view books 
* User able to search for content other users created 

**To Be Continued**

* User able to create groups
* User able to follow other students
* User able to add resource such as book from API (Especially users doing a book review)
* User able to vote others post
* User able to comment others post
* User able to create profile
* User able to post and view their post on their profile
* User able to view public feed from their interest
* User able to view random topic everyday in public feed
* User able to give feedback to developers about the technical problem they met or some nice to have functions to help developers to polish this app


### 2. URL Archetypes

* Login URL /login
   * user able to log in
   * user able to sign up
* Register URL /signup
   * user able to create an account
* Profile URL /userid/portfolio
    * user able to build their profile
* Detail URL /postid/detail
    * user able to see the detail of posts
* Home Feed URL /playground
   * User able to search for others
   * User able to view post of other users
* Post URL /post/create || update
    * user can add or modify a description to their post
    * user can add or modify a picture 

### 3. Navigation

**Tab Navigation**

* Log In
* Sign Up
* Portfolio
* PlayGround
* CURD Post
* Search Post
* ChatGPT


## Wireframes

![wireframe](https://i.imgur.com/B0r0E05.png)

### Interactive Prototype

<a href="https://www.loom.com/share/ff18511590cb49dba6d4e7867ad7a67b">
    <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/ff18511590cb49dba6d4e7867ad7a67b-with-play.gif">
  </a>

## Database
PostgreSQL DBeaver
### User table
CREATE TABLE v2users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
| Column        | Type         | Description              |
|---------------|--------------|--------------------------|
| user_id       | SERIAL       | Primary Key              |
| username      | VARCHAR(50)  | Unique username          |
| email         | VARCHAR(100) | Unique email             |
| password_hash | VARCHAR(255) | Hashed password          |
| created_at    | TIMESTAMP    | Timestamp of creation    |


### Post table
CREATE TABLE v2posts (
    post_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    summary VARCHAR(255),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
| Column     | Type         | Description              |
|------------|--------------|--------------------------|
| post_id    | SERIAL       | Primary Key              |
| title      | VARCHAR(100) | Title of the post        |
| summary    | VARCHAR(255) | Summary of the post      |
| content    | TEXT         | Content of the post      |
| created_at | TIMESTAMP    | Timestamp of creation    |
| updated_at | TIMESTAMP    | Timestamp of last update |

### Join table
CREATE TABLE v2user_posts (
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    PRIMARY KEY (user_id, post_id),
    FOREIGN KEY (user_id) REFERENCES v2users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES v2posts(post_id) ON DELETE CASCADE
);
| Column  | Type | Description                              |
|---------|------|------------------------------------------|
| user_id | INT  | Foreign Key referencing `v2users`        |
| post_id | INT  | Foreign Key referencing `v2posts`        |

The `user_posts` table establishes a many-to-many relationship between v2users and v2posts.
