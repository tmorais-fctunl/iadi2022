import javax.persistence.*

@Entity
data class Packages (
    @Id @GeneratedValue                 val packageID:Long,
                                        val description:String,
                                        val dimensions:Triple<Double W, Double H, Double L>
                                        val origin:String,
                                        val destination:String
    @OneToMany(mappedBy = "stateID")    val stateHistory:MutableSet<State>
   // @ManyToMany(mappedBy = "products")  val stores:MutableSet<Store>

) {
    override fun hashCode(): Int = packageID.toInt()
}

@Entity
data class State (
    @Id @GeneratedValue                 val stateID:Long,
    @ManyToOne(mappedBy = "packageID")  val packageID:Long,
                                        val timeStamp:Long,
                                        val state:String,
    //(mappedBy = "driverID")
    @ManyToOne                          val driverID:Long,
    //(mappedBy = "hubID")
    @ManyToOne                          val hubID:Long

) {
     override fun hashCode(): Int = stateID.toInt()
}

@Entity
data class Driver (
    @Id @GeneratedValue                 val driverID:Long,
    @OneToOne                           val truckID:Long,
    OneToMany(mappedBy = "stateID")     val deliveries:MutableSet<State>
) {
     override fun hashCode(): Int = driverID.toInt()
}

@Entity
data class Truck (
    @Id @GeneratedValue                 val truckID:Long,
    @OneToOne                           val driverID:Long
) {
    override fun hashCode(): Int = driverID.toInt()
}






@Entity
data class Messages (
    @Id @GeneratedValue                 val id:Long,
                                        val source:String,
                                        val destination:String,
                                        val subject:String,
                                        val body:String,
                                        val timeStamp:Long,
                                        val previousMsg:Long
    //@ManyToMany         val products:MutableSet<Product>
) {
    override fun hashCode(): Int = id.toInt()

    override fun toString(): String ="Store(id=${id}, name=${name})"
}

@Entity
data class OrderLine (
    @Id @GeneratedValue val id:Long,
    @ManyToOne          val product:Product,
    @ManyToOne          val order:Order,
    val quantity:Long,
    val unitprice:Long,
)

@Entity
data class Client (
    @Id @GeneratedValue             val number:Long,
    val name:String,
    @OneToMany(mappedBy = "client") val orders:MutableList<Order>
)

@Entity
@Table(name="OrderTable") // Cannot use Order as table name
data class Order (
    @Id @GeneratedValue              val number:Long,
    @OneToMany(mappedBy = "order")   val lines:MutableList<OrderLine>,
    @ManyToOne                       val client:Client
)
