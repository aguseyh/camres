import {Component} from "react";
import {Route} from 'react-router-dom';
import Home from "../views/Home";
import Proveedores from "../views/proveedores/Proveedores";
import {Redirect, Switch} from 'react-router-dom'
import NotFound from "../views/NotFound";

class Routes extends Component{
    render(){
        return(
            <Switch>
                <Route path="/index" exact component={Home} />

                {/*PROVEEDORES*/}
                <Route path="/proveedores" exact render={() => (<Proveedores/>)}/>

                <Route path="/" exact render={props => (
                    <Redirect
                        to={{
                            pathname: "/index"
                        }}
                    />
                )}/>

                <Route component={NotFound}/>

            </Switch>
        );
    }
}

export default Routes;

//<Route path="/proveedores" exact render={() => (<ErrorBoundary key="Proveedores"> <Proveedores/> </ErrorBoundary>)} />
