export class Card {

    private value: number;

    private suit: string;

    public getValue(): number {
        return this.value;
    }

    public setValue(value: number): void {
        this.value = value;
    }

    public getSuit(): string {
        return this.suit;
    }

    public setSuit(suit: string): void {
        this.suit = suit;
    }

}