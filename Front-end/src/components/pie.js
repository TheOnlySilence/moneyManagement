import React, { Component } from 'react';
import './pie.css';
import PieChart from 'react-minimal-pie-chart'; /* piechart library from https://www.npmjs.com/package/react-minimal-pie-chart */


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

export default Pie_spending