import {Component} from "react";
import {withRouter} from 'react-router-dom';

class Proveedores extends Component{

    constructor(props) {
        super(props);
    }

    render(){
        return(
          <div>
              <h1>PROVEEDORES</h1>
          </div>
        );
    }
}

export default withRouter(Proveedores);
