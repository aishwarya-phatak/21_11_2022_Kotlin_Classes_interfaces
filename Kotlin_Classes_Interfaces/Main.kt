interface OnLogin{
    fun onSucess() = println("on Success - login Called")
    fun onFailure() = println("on Failure - login  Called")
}

interface OnLogout{
    fun onSucess() = println("on Success - logout Called")
    fun onFailure() = println("on Failure - logout Called")
}

open class Person(private var aadharnumber : Int) {

    init {
        println("init of Person class")
        this.aadharnumber = aadharnumber
    }
    constructor() : this(0){
        println("Person secondary constructor")
    }

    open fun displayDetails(){
        println("display Details of Person class called")
        println("AadharNumber is $aadharnumber")
    }
}

class Student(private var rollNumber : Int, private var aadharnumber: Int): Person(aadharnumber), OnLogin, OnLogout{

    init {
        println("init of Student class")
        this.aadharnumber = aadharnumber
        this.rollNumber = rollNumber
    }

    fun setRollNumber(rollNumber: Int){
        this.rollNumber = rollNumber
    }

    fun getRollNumber():Int{
        return this.rollNumber
    }

    override fun displayDetails() {
        super.displayDetails()
        println("Student display details called")
        println("Rollnumber is $rollNumber")
    }

    override fun onSucess() {
        super<OnLogin>.onSucess()
        super<OnLogout>.onSucess()
        println("on success of student class called")
    }

    override fun onFailure() {
        super<OnLogin>.onFailure()
        super<OnLogout>.onFailure()
        println("on failure of student class")
    }
}

/*class MathematicalOperations(private var numberOne : Int, private var numberTwo : Int) {
    //private var numberOne: Int = 0
    //private var numberTwo: Int = 0
    init {
        println("The init block is called for Mathematical Operations class")
        this.numberOne = numberOne
        this.numberTwo = numberTwo
    }

    constructor() : this(0,0){
        println("secondary constructor () - default values")
    }

    constructor(num : Int) : this(num,num) {
        println("Secondary constructor () - with parameters ")
    }

    fun display() {
        println(
            "numberOne is : $numberOne" +
                    "  numberTwo is : $numberTwo"
        )
    }

    fun addition() : Int{
        return numberOne + numberTwo
    }

    override fun equals(other: Any?): Boolean {

        var m = other as MathematicalOperations
        if(this.numberOne != m.numberOne){
                return false
        }
        return this.numberTwo == m.numberTwo
    }
}

 */

fun main(){

    //type inference - without mentioning datatype compiler will check rhs
    var x : Int = 100
    var y = 110.76
    x.toFloat()      // cast to float
    println("${x.toFloat()}")
    var name = "Pratima"

    var s = Student(10,1045)
    s.displayDetails()
    s.onSucess()
    s.onFailure()
    /*var mathematicalOperations : MathematicalOperations = MathematicalOperations(11,12)
    mathematicalOperations.display()
    var resultAdd = mathematicalOperations.addition()
    println("Addition is $resultAdd")

    var m2 = MathematicalOperations()
    m2.display()
    var res = m2.addition()
    println("Res is $res")
     */

    /*var m1 = MathematicalOperations()
    m1.display()
    var m = MathematicalOperations(10,20)
    m.display()
    var result : Int = m.addition()
    println("Result : $result")

    m1.equals(m);

     */
}