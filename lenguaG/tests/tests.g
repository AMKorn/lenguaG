int generalCounter = 3;
int function(int counter){
    if(counter != 1){
        if(counter == 2){
        }
    } else {
    }
}

main {
    int localCounter = generalCounter;
    
    while(localCounter != 5){
        localCounter = function(generalCounter);
        out(localCounter);
    }
}

