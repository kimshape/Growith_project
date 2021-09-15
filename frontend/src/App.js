import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { Route } from 'react-router-dom';
import Header from './component/Header';
import RecruitBoard from './container/recruitBoard/RecruitBoard';
import RecruitBoardSaveForm from './container/recruitBoard/RecruitBoardSaveForm';
import RecruitBoardView from './container/recruitBoard/RecruitBoardView';
import RecruitBoardUpdateForm from './container/recruitBoard/RecruitBoardUpdateForm';
import Home from './container/Home';

function App() {
  return (
    <div>
      <Header />
      <Container>
        <Route path="/" exact={true} component={Home} />
        <Route path="/recruitBoard" exact={true} component={RecruitBoard} />
        <Route
          path="/recruitBoardSaveForm"
          exact={true}
          component={RecruitBoardSaveForm}
        />
        <Route
          path="/recruitBoard/:recruitBoardId"
          exact={true}
          component={RecruitBoardView}
        />
        <Route
          path="/recruitBoardUpdateForm/:recruitBoardId"
          exact={true}
          component={RecruitBoardUpdateForm}
        />
      </Container>
    </div>
  );
}

export default App;
