package nicestring


//1 -> si
//0 -> no
fun main() {
    val text = "baaa"
    println( validateDuplicateLetters(text))
    val validateVocal = validateVocal(text)
    println("validateVocal $validateVocal")
    val validateDuplicate = validateDuplicateLetters(text);
    println("validateDuplicate $validateDuplicate")
    val validateSubString = validateSubStringInvalid(text)
    println("validateSubString $validateSubString")
    val validateLowerCase = validateLowerCase(text)
    println("validateLowerCase $validateLowerCase")
    val validateAll = validateVocal + validateDuplicate + validateSubString + validateLowerCase
    if(validateAll >= 3) println(true) else println(false)

}

fun String.isNice(): Boolean {
    println( validateDuplicateLetters(this))
    val validateVocal = validateVocal(this)
    println("validateVocal $validateVocal")
    val validateDuplicate = validateDuplicateLetters(this);
    println("validateDuplicate $validateDuplicate")
    val validateSubString = validateSubStringInvalid(this)
    println("validateSubString $validateSubString")
    val validateLowerCase = validateLowerCase(this)
    println("validateLowerCase $validateLowerCase")
    val validateAll = validateVocal + validateDuplicate + validateSubString + validateLowerCase
    if(validateAll >= 3) return true else return false
}

fun validateSubStringInvalid(cadena: String) : Int{
    val listInvalid = listOf("ba", "be", "bu")
    for(textInvalid in listInvalid){
        if (cadena.contains(textInvalid)){
            return 0
        }
    }
    return 1
}

fun validateLowerCase(text: String) : Int{
    val validateLowerCase = text.matches("^[a-z]*$".toRegex());
    if(validateLowerCase) return 1;
    return 0
}

fun validateVocal(text: String) : Int{
    val countVocal = text.count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }
    if(countVocal > 2){
        return 1
    }
    return 0
}

fun validateDuplicateLetters(text: String) : Int{
    val maxDuplicate = text.map { ch ->
        val pair: Pair<Char, Int> = ch to text.count({ ("$ch{2}".toRegex()).containsMatchIn(text) })
        return@map pair.second
    }.maxOrNull()
    if((maxDuplicate ?: 0) >= 2){
        return 1
    } else return 0
}
