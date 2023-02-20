pipeline{
  agent any
  stages
  {
    stage('Build')
    {
      steps{
        echo "Creating a new User"
        creatingNewUser()
      }
    }
    stage('Test')
    {
      steps{
        echo "Login positive & negative test cases"
        	loginTest1(String Email,String Password,String Exp)
        
      }
    }
    stage('compile')
    {
      steps{
        echo "booking an appointment"
        BookAppointment()
      }
    }
    stage('Deploy')
    {
      steps{
        echo "Verifying an appointment"
        verifyAppointment()
      }
    }
  }
}
    
