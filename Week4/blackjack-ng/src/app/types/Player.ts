import { Card } from './Card';

export interface Player {

    hand: Card[];
    name: string;
    score: number;
    tokens: number;

}