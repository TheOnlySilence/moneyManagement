import React, { Component } from 'react';
import './mm_content.css';
import PieChart from 'react-minimal-pie-chart'; /* piechart library from https://www.npmjs.com/package/react-minimal-pie-chart */
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts'; /* chart library from http://recharts.org/en-US/guide/getting-started */

const Graph_data = [
  {name: 'Jan 1', uv: 4000, pv: 2400, amt: 2400},
  {name: 'Jan 17', uv: 3000, pv: 1398, amt: 2210},
  {name: 'Jan 22', uv: 2000, pv: 9800, amt: 2290},
  {name: 'Feb 7', uv: 2780, pv: 3908, amt: 2000},
  {name: 'Feb 19', uv: 1890, pv: 4800, amt: 2181},
  {name: 'Feb 22', uv: 2390, pv: 3800, amt: 2500},
  {name: 'Feb 25', uv: 3490, pv: 4300, amt: 2100},
];



const Status_data = {Account_Bal: 578, Monthly_exp: 732.3, Remain_bud: 81, Finance_stat: "BAD"}

const Transaction_data = [
  {
    Date: "8/20/18", 
    Time: "3:14 PM EST", 
    Category: "Merchandise", 
    Name: "Student Book Store", 
    Amount: 145.65, 
    Location: "330 E College Ave, State College, PA 16801", 
    Payment_Method: "Card swiped"}, 
  {
    Date: "8/21/18", 
    Time: "1:59 PM EST", 
    Category: "Merchandise", 
    Name: "Amazon", 
    Amount: 20.67, 
    Location: "amazon.com", 
    Payment_Method: "Online"}, 
  {
    Date: "8/22/18", 
    Time: "11:45 AM EST", 
    Category: "Dining", 
    Name: "Chick-fil-A", 
    Amount: 11.75, 
    Location: "1938 N Atherton St, State College, PA 16803", 
    Payment_Method: "Card swiped"}, 
  {
    Date: "8/22/18", 
    Time: "3:01 PM EST", 
    Category: "Grocery", 
    Name: "Wegmans", 
    Amount: 105, 
    Location: "345 Colonnade Blvd, State College, PA 16803", 
    Payment_Method: "Chip"}, 
  {
    Date: "8/23/18", 
    Time: "3:35 PM EST", 
    Category: "Merchandise", 
    Name: "Fine Wine & Good Spirits", 
    Amount: 36.14, 
    Location: "1682 N Atherton St, State College, PA 16803", 
    Payment_Method: "Chip"}, 
  {
    Date: "8/23/18", 
    Time: "3:57 PM EST", 
    Category: "Gas/Automotive", 
    Name: "Exxon", 
    Amount: 25, 
    Location: "315 W Aaron Dr, State College, PA 16801", 
    Payment_Method: "Card swiped"}, 
  {
    Date: "8/24/18", 
    Time: "12:30 AM EST", 
    Category: "Dining", 
    Name: "Cafe 210 West", 
    Amount: 13, 
    Location: "210 W College Ave, State College, PA 16801", 
    Payment_Method: "Card swiped"}, 
  {
    Date: "8/24/18", 
    Time: "1:35 AM EST", 
    Category: "Travel", 
    Name: "Uber Technologies", 
    Amount: 7.35, 
    Location: "Uber", 
    Payment_Method: "Apple Pay"}, 
  {
    Date: "8/24/18", 
    Time: "10:00 AM EST", 
    Category: "Healthcare", 
    Name: "CVS", 
    Amount: 13.01, 
    Location: "138 E Beaver Ave, State College, PA 16801", 
    Payment_Method: "Chip"}, 
  {
    Date: "8/24/18", 
    Time: "7:00 PM EST", 
    Category: "Entertainment", 
    Name: "The State Theatre", 
    Amount: 10, 
    Location: "130 W College Ave, State College, PA 16801", 
    Payment_Method: "Chip"}, 
  {
    Date: "8/25/18", 
    Time: "6:00 AM EST", 
    Category: "Insurance", 
    Name: "Renters Insurance", 
    Amount: 30.74, 
    Location: "progressive.com", 
    Payment_Method: "Online"}
  ]

class Content extends Component {
  
  render() {
    return (
      <div className="_content">
        <div className="_content_title">
            <h2>Financial Analysis</h2>
            <p>23:14, Thursday, Jan 26, 2019</p>
        </div>
         <div className="_content_display">
              <Graph_spending />
              <Pie_spending />
        </div>
            <Status_card_list />
            <Detail_contents />
      </div>
    );
  }
}

class Graph_spending extends Component {
    render(){
        return(
            <div>
              <h3>Daily spending</h3>
                  <LineChart width={500} height={250} data={Graph_data} margin={{ top: 5, right: 20, bottom: 5, left: 0 }}>
                      <Line type="monotone" dataKey="uv" stroke="#8884d8" />
                      <CartesianGrid stroke="#ccc" strokeDasharray="5 5" />
                      <XAxis dataKey="name"  />
                      <YAxis />
                      <Tooltip />
                </LineChart>
          </div>
        )
    }
}

class Pie_spending extends Component {
    render(){
        return(
            <div className="_content_pie">
            <h3>Spending ratio</h3>
                <PieChart radius={50} animate={true}
              data={[
                { title: 'One', value: 40, color: '#6982FF' },
                { title: 'Two', value: 27, color: '#7A8CE9' },
                { title: 'Three', value: 20, color: '#929EE3' },
                { title: 'Four', value: 7, color: '#C6CBE9' }
              ]}
            />
            </div>
        )
    }
}

class Status_card_list extends Component{
    render(){
      return(
        <div className="card_list">
          <_Account_Bal />
          <_Monthly_exp />
          <_Remain_bud />
          <_Finance_stat />
        </div>
      )
    }
}

//Account_Bal: 578, Monthly_exp: 732.3, Remain_bud: 81, Financial_stat: "BAD"
class _Account_Bal extends Component{
  render(){
    return(
      <div className="card">
      <div className="card_content">
        <ul>
          <li>$ {Status_data.Account_Bal}</li>
          <li>Account Balance</li>
        </ul>
        <img src="https://image.flaticon.com/icons/svg/259/259473.svg" alt="Account Balance"></img>
        </div>
      </div>
    )  
  }
}

class _Monthly_exp extends Component{
  render(){
    return(
      <div className="card">
        <ul>
          <li>$ {Status_data.Monthly_exp}</li>
          <li>Monthly Expenditure</li>
        </ul>
        <img src="https://image.flaticon.com/icons/svg/743/743131.svg" alt="Monthly Expenditure"></img>
      </div>
    )  
  }
}

class _Remain_bud extends Component{
  render(){
    return(
      <div className="card">
      <div className="card_content">
        <ul>
          <li>$ {Status_data.Remain_bud}</li>
          <li>Monthly Budget</li>
        </ul>
        <img src="https://image.flaticon.com/icons/svg/741/741744.svg" alt="Remaining Monthly Budget"></img>
      </div>
        
      </div>
    )  
  }
}

class _Finance_stat extends Component{
  render(){
    return(
      <div className="card">
      <div className="card_content">
        <ul>
          <li>{Status_data.Finance_stat}</li>
          <li>Financial Status</li>
        </ul>
        <img src="https://image.flaticon.com/icons/svg/910/910129.svg" alt="Financial Status"></img>
        </div>
      </div>
    )  
  }
}

class Detail_contents extends Component{
  render(){
    return(
      <div className="Detail_box">
      <div className="Detail_info">
        <h3>Recent Transactions</h3>
        {Transaction_data.map((trans, index) => {
          return <Trans_info Date={trans.Date} Time={trans.Time}  Name={trans.Name} Category={trans.Category}/>
        })}
      </div>
      <div className="Detail_info">
      <h3>Financial Status Report</h3>
        <Advice_info/>
      </div>
      </div>
    )
  }
}

class Trans_info extends Component{
  render(){
    return(
      <div>{this.props.Date} {this.props.Time} {this.props.Name} {this.props.Category}</div>
    )
  }
}

class Advice_info extends Component{
  render(){
    return(
      <div>
        
        <ul>
          <li>Monthly budget alert</li>
          <li>Too much expenditure on cloting</li>
          <li>Account Management setting required</li>
        </ul>
        </div>
    )
  }
}


export default Content;
