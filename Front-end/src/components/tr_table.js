import React, { Component } from 'react';
import  { useState } from "react";
import './tr_table.css';
import ReactDataGrid from 'react-data-grid'

const defaultColumnProperties = {
    sortable: false,
    width: 125,
    frozen: true
  };

const columns = [
    { key: 'Date', name: 'DATE' },
    { key: 'Time', name: 'TIME' },
    { key: 'Category', name: 'CATEGORY' },
    { key: 'Name', name: 'VENDOR' },
    { key: 'Amount', name: 'AMOUNT' } ].map(c => ({ ...c, ...defaultColumnProperties }));
  
  const rows = [{id: 0, title: 'row1', count: 20}, {id: 1, title: 'row1', count: 40}, {id: 2, title: 'row1', count: 60}];
  

  const Transaction_data = [
    {
      Date: "8/20/18", 
      Time: "3:14 PM EST", 
      Category: "Merchandise", 
      Name: "Student Book Store", 
      Amount: 145.65, 
      Location: "330 E College Ave, State College, PA 16801", 
      Payment_Method: "Card swiped",
      }, 
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


    const sortRows = (initialRows, sortColumn, sortDirection) => rows => {
        const comparer = (a, b) => {
          if (sortDirection === "ASC") {
            return a[sortColumn] > b[sortColumn] ? 1 : -1;
          } else if (sortDirection === "DESC") {
            return a[sortColumn] < b[sortColumn] ? 1 : -1;
          }
        };
        return sortDirection === "NONE" ? initialRows : [...rows].sort(comparer);
      };
      

  class Trans_table extends Component {
    render(){
      return (<ReactDataGrid
      columns={columns}
      rowGetter={i => Transaction_data[i]}
      resizeable = {true}
      rowsCount= {this.props.Row_count}
      minHeight={250} />);
  }
}


export default Trans_table;





