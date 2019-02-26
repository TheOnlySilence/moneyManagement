import React,{ PureComponent } from 'react';
import { connect } from "react-redux";
import { LoginBox, LoginWrapper, InputBox,Button } from "./style";
import axios from 'axios';

class Login extends PureComponent {
    constructor(){
        super()
        this.state = {
            error:{},
            submitted: false,
            user_id: ''
        }

        this.handleClick = this.handleClick.bind(this)
    }

    handleClick (){
    }

    render(error) {
        return (
            <LoginWrapper>
                <LoginBox>
                    <InputBox placeholder='user ID' />
                    <Button onClick={this.handleClick}>Login</Button>
                </LoginBox>
            </LoginWrapper>
        )
    }
}


export default (Login);