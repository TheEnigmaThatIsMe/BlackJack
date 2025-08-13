
# Blackjack Game (Java)

A simple **Blackjack** implementation in Java.  
Demonstrates object-oriented design, card game logic, shuffling algorithms, and clean coding practices.

---

## **Core Concepts**

### 1. **Object-Oriented Design**
The game is split into modular classes:
- `Card` – Represents an individual playing card with `Suit` and `Rank`.
- `Suit` – Enum for the four suits: Clubs, Diamonds, Hearts, Spades.
- `Rank` – Enum for the thirteen card ranks: Ace through King.
- `Deck` – Holds a list of cards, supports shuffling (Fisher–Yates) and dealing.
- `Game` – Controls the Blackjack gameplay loop.

### 2. **Fisher–Yates Shuffle**
We use the **Fisher–Yates algorithm** to ensure a **uniform random shuffle** of the deck.  
It can also be made **seedable** for reproducible results (useful in testing and provably fair games).

### 3. **Blackjack Rules Implemented**
- Ace can be worth 1 or 11 depending on the best outcome.
- Face cards are always worth 10.
- Dealer must hit until reaching 17 or more (configurable soft 17 rule).
- Player wins, loses, or pushes based on standard Blackjack rules.

### 4. **Decks**
The game is configurable for the number of decks to play with.

### 5. **Reshuffling**
When the deck runs out of cards, it automatically **refills and reshuffles**.

---

## **How to Run**

### **Prerequisites**
- Java 24+ installed ([Download Java](https://jdk.java.net/24/))
- A terminal or IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extension)

### **Steps**
1. **Clone or Download** this project:
    ```bash
    git clone https://github.com/TheEnigmaThatIsMe/BlackJack.git
    cd BlackJack
    ```

2. **Compile the program**:
    ```bash
    javac -d out $(find . -name "*.java")
    ```

3. **Run the game**:
    ```bash
    java -cp out BlackJackApp
    ```

---

## **Example Gameplay**
```
How many decks do you want to play with? 1
--- New Round ---
Dealer's visible card: THREE of HEARTS (Value: 3)
Your hand: [NINE of HEARTS, EIGHT of HEARTS] (Value: 17)
Do you want to hit or stand? (h/s): s

Dealer's turn.
Dealer's hand: [THREE of HEARTS, NINE of DIAMONDS] (Value: 12)

--- Results ---
Your final hand: [NINE of HEARTS, EIGHT of HEARTS] (Value: 17)
Dealer's final hand: [THREE of HEARTS, NINE of DIAMONDS, SEVEN of HEARTS] (Value: 19)
Dealer wins.
Play another round? (y/n): n
Thanks for playing!
```
---

## **License**
MIT License — free to use and modify.
