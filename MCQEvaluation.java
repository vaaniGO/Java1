import java.util.Scanner;
class MCQEvaluation
{
    private char answers[][], key[];
    private int n;
    /*
    Below are given examples of VALID single-line entries as it occurs in real-life:
    A   C C   B D
    BBA CCA
    A B C D E
    ABCDE
    Below are given INVALID examples of such single-line entries:
    A * B C C A
    A B C F E
    A-B-CD E
     */
    void input() /*# Fix this method. */
    {
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter the no. of participants (N): "); 
        n= sc.nextInt(); sc.nextLine();
        if ( n<2 || n>11)
        {
            System.out.println("INPUT SIZE OUT OF RANGE."); 
            System.exit(0);
        }
        answers= new char[n][5]; 
        key= new char[5];

        System.out.println("\nEnter the answers of "+n+" Participants below:");
        for (int i=0; i<n; i++) //taking participant answer inputs
        {
            System.out.print("Participant "+(i+1)+": "); 
            String str= sc.nextLine(); 
            for(int j=0,k=0,len=str.length(); j<len; j++)
            {
                char ch= Character.toUpperCase(str.charAt(j));
                if (ch=='A' || ch=='B' || ch== 'C' || ch=='D')
                    answers[i][k++]= ch;
                else if (ch!=' ')
                {
                    System.out.println("Invalid character found in answer-set! Kindly reenter answer."); 
                    i--;
                }
            }
        }
        System.out.println("\nEnter the correct answers below:"); //taking key answer input
        for(int i=0; i<5; )
        {
            System.out.print("Key: ");
            String str= sc.nextLine();
            for(int j=0,len=str.length(); j<len; j++)
            {
                char ch= Character.toUpperCase(str.charAt(j));
                if (ch=='A' || ch=='B' || ch== 'C' || ch=='D')
                    key[i++]= ch;
                else if(ch!=' ')
                {
                    System.out.println("Invalid character found in answer-set! Kindly reenter answer."); 
                    i=0;
                }
            }
        }
    }

    void findScore()
    {
        int score=0, max=0; 
        String topScorer="";
        for (int i=0; i<n; i++) //loop for 'n' participants
        {
            score=0;
            for (int j=0; j<5; j++) //loop for 5 questions
                if (answers[i][j]==key[j]) //checking each answer
                    score++; 
            if (score > max) //updating participant number for topScorerest score
            {   
                max= score;
                topScorer= "Participant "+(i+1);
            }
            else if(score == max)
                topScorer+= "\n\t\tParticipant "+(i+1);
            System.out.println("Participant "+(i+1)+" = "+score);
        }
        System.out.println("\nHighest score: "+topScorer);
    }

    public static void main()
    {
        MCQEvaluation obj= new MCQEvaluation(); 
        obj.input(); 
        System.out.println("\nScores:");
        obj.findScore();
    }
}
/** I can well UNDERSTAND... I am just being 'tolerated'.... but the reverential respect (with
love) is towards HER only!!! */