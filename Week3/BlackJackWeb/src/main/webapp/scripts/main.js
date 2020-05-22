var suitUrls = {
    HEARTS: "https://icon2.cleanpng.com/20180508/rgw/kisspng-playing-card-ace-of-spades-computer-icons-suit-5af1c5ee6c9189.0637322215257942864447.jpg",
    SPADES: "https://cdn1.iconfinder.com/data/icons/gaming-entertainment-vol-2/64/clubs-512.png",
    DIAMONDS: "data:image/png;base64,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",
    CLUBS: "https://w7.pngwing.com/pngs/856/50/png-transparent-red-heart-illustration-suit-playing-card-heart-card-game-ny-s-love-game-hearts.png"};
class GameObject {
    constructor(value) {
        this.value = value;
    }

    displayValue() {
        console.log(this.value);
    }

}

class Card extends GameObject {
    constructor(suite, value, face) {
        super(value);
        this.suite = suite;
        this.value = value;
        this.face = face;
    }
}

class CardService {

    createCardElement(card) {
        //create div element for card
        let cardElement = document.createElement("div");
        //add classses
        cardElement.setAttribute("class", "card playerCard");
        //set value of card
        if (card.value === 11) {
            cardElement.innerHTML = "A";
        } else {
            cardElement.innerHTML = card.value;
        }
        //place suite on card
        let cardSuite = document.createElement("img");
        let suitImage = suitUrls[card.suit];
        cardSuite.setAttribute("src", suitImage);
        cardElement.appendChild(cardSuite);
        return cardElement;
    }
}

class Player {

    constructor(hand, score, name, tokens) {
        this.hand = hand;
        this.score = score;
        this.name = name;
        this.tokens = tokens;
    }

}

function setUpDealerCards(dealer) {
    let cardService = new CardService();
    let cardElement = cardService.createCardElement(dealer.shownCard);
        let hand = document.getElementById("dealerHand")
        hand.insertBefore(cardElement, hand.lastChild.previousSibling);
}

function setPlayerCards(player) {
    let cardService = new CardService();
    for (card of player.hand) {
        let cardElement = cardService.createCardElement(card);
        let hand = document.getElementById("playerHand")
        hand.insertBefore(cardElement, hand.lastChild.previousSibling);
    }

    displayPlayerScore(player.score);

}

function playerHit(event, player) {
    event.preventDefault();

    if (player.score >= 21) {
        let playerBtns = document.getElementsByClassName("playerInput");
        for (btn of playerBtns) {
            console.log(btn);
            btn.setAttribute("disabled", true);
        }
        displayPlayerScore("BUST");
    }
}

function displayPlayerScore(score) {
    document.getElementById("playerScore").innerHTML = score;
}

function startGame(gameObject) {

    setPlayerCards(gameObject.player);
    setUpDealerCards(gameObject.dealer);

}

function getBlackJackGame() {
    //1. set up XHR object
    let xhr = new XMLHttpRequest();

    //ready state?
    //2. register callback function readystate change
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            let gameObject = JSON.parse(xhr.responseText);
            startGame(gameObject);
        }
    }

    //3. open request
    xhr.open("GET", "api/startgame?user=DoomSlayer");
    //4. send it
    xhr.send();

}

window.onload = function () {
    this.getBlackJackGame();
    this.document.getElementById("playerHitBtn").addEventListener("click", (e) => playerHit(e, player));
}

