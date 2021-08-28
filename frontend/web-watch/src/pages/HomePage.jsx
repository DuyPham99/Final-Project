import Header from '../components/Header/index';
import Footer from '../components/Footer/index';
import Home from '../components/Home/index';
import Login from '../components/Login/index';
import News from '../components/News/index';
import Contact from '../components/Contact/index';
import Cart from '../components/Cart/index';
import Details from '../components/Details/index';
import Products from '../components/Products/index';
import './index.scss';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ProductPage from 'components/ProductPage';

function HomePage() {
    return (
        <>
            <Router>
                <Header />
                <div className="homepage">
                    <Switch>
                        <Route path='/tintuc' component={News}></Route>
                        <Route path='/' exact component={Home}></Route>
                        <Route path='/dangnhap' component={Login}></Route>
                        <Route path='/lienhe' component={Contact}></Route>
                        <Route path='/giohang' component={Cart}></Route>
                        <Route extract path='/sanpham/:idProduct' component={ProductPage} />
                        <Route path='/products/:id' component={Details} />
                    </Switch>
                </div>
            </Router>
            <Footer />
        </>

    );
}
export default HomePage;