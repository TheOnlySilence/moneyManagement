import React, { Component } from 'react';
import './Info_box.css';

const info_box_data = {
    Balance : 8000,
    Min_payment : 270,
    Pay_due : "03/01/2019",
    Credit_limit : 10000,
    Cash_backs : 180
}

class Info_box extends Component {
    render(){
        return(
            <div className="_info_box">
                <ul>
                    <li>Balance $ {info_box_data.Balance}</li>
                    <li>Minimum payment $ {info_box_data.Min_payment}</li>
                    <li>Payment due {info_box_data.Pay_due}</li>
                    <li>Credit limit $ {info_box_data.Credit_limit}</li>
                    <li>Cash_backs $ {info_box_data.Cash_backs}</li>
                </ul>
            </div>
        )
    }
}

export default Info_box