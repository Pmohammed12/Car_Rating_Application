package com.myapp.carrating

class CarRating {
    var vehcileMake = ""
    var vehicleModel = ""
    var fuelType = ""
    var manualTransmission = ""
    var automaticTransmission = ""
    var rating= 0

    override fun toString(): String {
        return """
            vehicleMake = $vehcileMake
            vehicleModel = $vehicleModel
            fuelType = $fuelType
            manualTransmission = $manualTransmission
            automaticTransmission = $automaticTransmission
            rating = $rating
            
        """
    }
}