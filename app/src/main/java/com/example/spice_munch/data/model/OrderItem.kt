package com.example.spice_munch.data.model

data class OrderItem(
    val name: String,
    val option: Option,
    val extras: List<Extra>,
    val allergies: List<Allergy>,
    val spiceLevel: String,
    val amount: Double,
    val price: Double
)


data class Order(
    val orderItems: List<OrderItem>,
    val totalPrice: Double
)

enum class Option {
    CHICKEN, LAMB, PRAWN, VEGETABLE
}

enum class Allergy {
    NUTS, DAIRY, SEAFOODS, WHEAT
}

enum class Extra {
    MUSHROOM, CREAM, CORIANDER, ONION
}