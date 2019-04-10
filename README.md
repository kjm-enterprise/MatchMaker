
## App Overview

**Why Matchmaker?**

MatchMaker was designed to bridge like minded gamers to one another.  The idea of the app
is to connect gamers in a *"Tinder"* like fashion through showcasing their interests in gaming 
and allow the user to match with another gamer that allows them to play together. The apps 
intention is to just connect gamers play matches together, however if love were to happen it
would happen.  Happy Matching! 

**Our Team**

James Mattos - App presentation 

Kanyon Wyman - Back End

Michael Sanchez - Front End

**Functional Inventory**

Currently the app is mostly cosmetic.  The app does not actually do what it is 
intended to do, however, the overall concept is shown in the app. 

**External Web Services**

Currently the only external web service fully implemented is [google sign in 
service](https://github.com/googlesamples/google-services/tree/master/android/signin).
This eventually would be used to tie user information to the account.  
   

## Testing

**NOTE*** app was kept in portrait mode.

**Devices**

Motorola G6 API 26 - On this device it seemed to work functionally okay. 
The app was able to jump from correct fragment to correct fragment.

**Emulators**

Nexus 5X API 24 - On this emulator it seemed to work functionally okay. 
The app was able to jump from correct fragment to correct fragment.

Samsung SM - G930U- On this emulator it seemed to work functionally okay. 
The app was able to jump from correct fragment to correct fragment.

## User Stories

**PC Gamer:**
 
The PC Gamer, is looking for more competitive matches and partners
to game with.  The PC Gamer wants make money through gaming tournaments,
and wants to meet like minded gamers. If ever the PC Gamer needs someone
to tryout and be a key part of a team in a professional scene, they can
search and easily set up tryouts.  They intend on using the Matchmaking
app for just that! 


**Console Gamer:** 

The console gamer wants to matchmake with friends that have the 
same console as them to play at similar levels as each other. Currently, 
the console gamer has a few select friends that can only play at certain 
times.  The console game would utilize the matchmaking feature to increase
their friend circle, and ability to play with other console players.
Whether they need a partner to spar with, or a fifth person to jump in a
squad to beat a raid boss, the matchmaking app can help them do what they need.

**Casual Gamer:** 

The Casual Gamer is someone whose idea of fun is not the enjoyment of
showing other people their ability to out-smart and out-play them,
but rather laying back and playing a game that maybe revolves more around
figuring something out with a group of friends. Maybe this person is
older and can’t keep up with the reaction time of the younger Gamers 
that dominate the market. With matchmaker, they can find a group of people
just like them and not have to worry about other players not giving them a 
chance to even play.

**Avid Gamer:**
 
The avid gamer is a passionate about what their gaming.  They take it very 
seriously and want to match with gamers that are at their very best, 
so that they too can be better.  They don’t want any n00bs up in their 
matches. Avid gamers take pride in their machines and want to flaunt it.

**Lover Lurkers:** 

Since the gamers are also matching with like minded gamers,
this could also will be a platform for sparking a relationship with
another gamer (although this isn’t the intended purpose, but love happens)
. This user, may want to find a companion that they can not only play their
 own version of Smash, but also play video games with. 

## Technical & Documentation Links

[Back End README.md placeholder!!!!](https://kjm-enterprise.github.io/MatchMake_BackEnd/)

[Wire Frame](docs/wireFrameMatchMaker.png)

[ERD Front End](docs/erd_%20matchmaker_android.png)

[DDL Placeholder]()

[Front End JavaDoc](docs/api)



## Third Party Libraries & Services

[Google GSON](https://github.com/google/gson)

Used to convert Java objects into JSON then back

[Facebook Stetho](https://github.com/facebook/stetho)

Used to see if the the databases were talking to each other.

[Google SignIn](https://github.com/googlesamples/google-services/tree/master/android/signin)

Used to implement Google SignIn on the app

[Google Firebase](https://github.com/firebase/)

Intended use was to allow users to message between each other. 


## Copyrights & licenses

Copyright 2019 KJM Enterprise 

Licensed under the Apache Licences Version 2.0 (the "License"); you may not use
this file except in compliance with the Licenses.

[Link To License](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an as is basis, without warranties or conditions of any kind, wither express or 
implied. See the language governing permissions and limitations under the License. 

## Deployment Instructions

Step 1 - [Clone Git Repository](https://github.com/kjm-enterprise/MatchMaker) 

Step 2 - When creating a new project clone the project from the cloned link generated in the Git Repo for MatchMaker.

Step 3 - DO NOT OPEN THE project when prompted to. Keep the project closed and select the import option.

Step 4 - Then import the project from Maven and ensure that the Java language level is set at 1.8.

Step 5 - In the dropdown next to the run and debug symbols, create an app configuration and call it "app". This will allow you to build the app fully.

Step 6 - Download a google-services.json file of your own to obtain a key to utilize firebase messaging. 
those steps [can be found here](https://firebase.google.com/docs/android/setup).

Step 7 - Run the project and your app should be up and running.

## User Instructions

1) Launch the app

2) Sign in with a valid google account.  If you do not have a google account [click here to sign up](https://accounts.google.com/signup/v2/webcreateaccount?hl=en-GB&flowName=GlifWebSignIn&flowEntry=SignUp&nogm=true). 

3) After signing in you will be prompted to a screen showing you first match option. The option
will either allow you to attempt to match with the other user or pass on the user.  You will only
match with the user if the other user has the same mutual desire to match with you. 

4) After you have a match with a user, they will be stored in your "Matches" tab in the button below.  Eventually 
this feature will let you recall the information that was presented to you upon first matching.

5) If you would like to message your match you may do so within the messaging function of the app. This 
will allow you to set up communication together to actually game together! 

6) The last item to explore is your "User Profile" which will eventually allow ou to set your different
gaming consoles and allow you to change your profile picture that is shown to others. 

## Current App Status

Currently the app is mostly just a cosmetic approach of what we would hope the 
functionality could perform. The app has google sign in authentication and 
is navigational through its main fragments in the bottom nav bar only. 

## Stretch Goals

We would like to have the app fully functional and complete so users could
actually match with one another.  Furthermore, we would like for the users to
have the ability to message back and forth utilizing Firebase messaging. 

**Aesthetic and Cosmetic Improvements**

Aesthetically we would like to make the following improvments:

* Swipe right or left for matching or passing

* User ability to have multiple images that they can upload

* A clear messaging system that is styled perfectly

* Recycler view of messages received and matches.


**[GitHub Link](https://kjm-enterprise.github.io/MatchMaker/)**
