package ex3

class Weather {
    @ValidText(["Sunny", "Rainy", "Cloudy"])
    var desc: String = "Sunny"
}