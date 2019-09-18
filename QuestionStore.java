package com.example.nitinr.fblaqtime;

public class QuestionStore {
    //private instance variables initialized
    private String myAnswer, myQuestion, myChoice1, myChoice2, myChoice3;
    private int myNumber;

    QuestionStore(int randomNumber){
        myNumber = randomNumber;
        myAnswer = "";
        myQuestion = "";
        myChoice1 = "";
        myChoice2 = "";
        myChoice3 = "";
    }

    //Setter method to get the string myQuestion to get the quiz question
    public void storeQuestions() {
       String[] questions = {"What does FBLA stand for?", "How many competitive events are there?", "What is the FBLA-PBL?", "Which of the following is part of the FBLA Creed?",
       "Which of these is part of the Code of Ethics?","What is one focus of the FBLA mission?", "What does FBLA offer?", "According to dress code, which is NOT acceptable?",
       "According to dress code, which IS acceptable?", "One FBLA fundraising partner is?", "One FBLA scholarship program is?", "Where can you buy FBLA merchandise?",
       "One FBLA Education Partner is?", "What are the three cores of the Business Achievement Awards?", "In what location can the national conference be held?",
       "What are the 3 R's for member recruitment?", "How many national officers are there?", "In what FBLA region does Florida fall under?","Who founded FBLA?",
       "In what year was FBLA founded?", "In what state was the first high school chapter founded?", "According to Parliamentary Procedure, what is a motion?",
       "Where will the 2019 National Conference take place?", "What is the 2019 membership theme?", "Which of these is a membership benefit?"};
       for(int i =0; i< questions.length; i++) {
           myQuestion = questions[myNumber];
       }

    }
    //Setter method to get the three answer choices for each quiz question
    public void  storeChoices(){
        String[][] choices = {{"Future Bureaucratic Leaders of America ","Future Business Leaders of America", "Future Business Leading Americans"},
                             {"45", "72", "15"},
                             {"Project Based Learning", "Public Business Leadership", "Phi Beta Lambda"},
                             {"Education is everyone's right", "Competition is healthy", "Leading inspires"},
                             {"Never disrespect", "Be honest and sincere", "Be altruistic"},
                             {"Academic Competitions", "Starting Chapters", "Promoting dress code"},
                             {"Loans", "Grants", "Scholarships"},
                             {"Athletic shoes", "Bow Ties", "Belts"},
                             {"Flip Flops", "Golf shoes", "Bow Ties"},
                             {"Donation Foundation", "Harvard Student Agencies", "Business Fundraiser"},
                             {"Express Scholarship program", "European Innovation Academy", "Technology Scholars"},
                             {"Market Place", "Shop", "Exchange Center"},
                             {"College Board", "Harvard Student Agencies", "Reach and Teach Inc."},
                             {"Service, Education, and Progress", "Wealth, Recognition, Fame", "Success, Knowledge, Growth"},
                             {"Philadelphia, Pennsylvania", "Chicago, Illinois", "Los Angeles, California"},
                             {"Recruitment Retention Recognition", "Recall Remember Recite", "Retain Reward Realize"},
                             {"10", "2", "9"},
                             {"Easter Region", "Southern Region", "Bottom Region"},
                             {"Hamden L. Forkner", "Hamilton G. Stalner", "Carl Y. Grey"},
                             {"1856", "1937", "2000"},
                             {"Tennessee", "Florida", "Texas"},
                             {"Recommendation for a candidate", "Proposal for a certain action", "Belief or opinion"},
                             {"Tallahassee, Florida", "Atlanta Georgia", "San Antonio, Texas"},
                             {"Lead Teach Follow", "Create Lead Inspire", "Learn Grow Educate"},
                             {"Grants", "Full rides to university", "Starting a Chapter"},};

        myChoice1 = choices[myNumber][0];
        myChoice2 = choices[myNumber][1];
        myChoice3 = choices[myNumber][2];
    }


    //Setter method to get the answer for each question
    public void storeAnswers(){
        String[] answers = {"Future Business Leaders of America", "72", "Phi Beta Lambda","Education is everyone's right","Be honest and sincere", "Academic Competitions",
                "Scholarships", "Athletic shoes", "Bow Ties", "Harvard Student Agencies","European Innovation Academy", "Market Place", "Reach and Teach Inc.",
                "Service, Education, and Progress","Chicago, Illinois","Recruitment Retention Recognition","9", "Southern Region", "Hamden L. Forkner", "1937", "Tennessee",
                "Proposal for a certain action", "San Antonio, Texas", "Create Leader Inspire", "Starting a Chapter"};
        for(int i =0; i< answers.length; i++) {
            myAnswer = answers[myNumber];
        }
    }
    //Getter method to get the random number that will display random questions
    public int getRandomNumber(){
        return myNumber;
    }
    //Getter method to get the question
    public String getQuestion(){
        return myQuestion;
    }
    //Getter method to get first choice in the multiple choice
    public String getChoice1(){
        return myChoice1;
    }
    //Getter method to get second choice in the multiple choice
    public String getChoice2(){
        return myChoice2;
    }
    //Getter method to get third choice in the multiple choice
    public String getChoice3(){
        return myChoice3;
    }
    //Getter method to get the answer to the question
    public String getAnswer(){
        return myAnswer;
    }

    }

