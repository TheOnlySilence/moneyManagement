import React, { Component } from 'react';
import './ACC_INFO.css';
import Trans_table from './tr_table'
import Pie_spending from "./pie"
import Info_box from "./Info_box"
class Acc_info extends Component {
    render() {
      return (
        
            <div className="_content">
                <div className="_content_title">
                    <h2>Account Information</h2>
                    <p>23:14, Thursday, Jan 26, 2019</p>
                </div>
                <div className="_acc_display2">
                    <Info_box/>
                    <Pie_spending />
                </div>
                    <h3>Transactions</h3>
                    <div className="big_table">
                   <Trans_table Row_count={11}/>
                   </div>
            </div>
       
      );
    }
  }

  
  
  export default Acc_info;