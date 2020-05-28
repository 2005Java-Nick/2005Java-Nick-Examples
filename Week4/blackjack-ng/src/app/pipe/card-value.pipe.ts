import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cardValue'
})
export class CardValuePipe implements PipeTransform {

  transform(value: number): string {
    return value === 11 ? 'A' : value.toString();
  }

}
