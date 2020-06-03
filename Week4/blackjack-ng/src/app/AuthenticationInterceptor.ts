import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

    intercept(request, next) {

        const newRequest = request.clone({withCredentials: true});

        return next.handle(newRequest);
    }

}