import logo from './logo.svg';
import './App.css';
import { Button, Container } from 'react-bootstrap';
import { Route } from 'react-router-dom';
function App() {
  return (
    <div>
      <Container>
        <Route path="/recruitBoard" exact={true} component={''} />
        <Route path="/saveForm" exact={true} component={''} />
        <Route path="/recruitBoard/:id" exact={true} component={''} />
        <Route path="/updateForm/:id" exact={true} component={''} />
        {/* <Route path="/loginForm" exact={true} component={''} />
        <Route path="/joinForm" exact={true} component={''} /> */}
      </Container>
    </div>
  );
}

export default App;
