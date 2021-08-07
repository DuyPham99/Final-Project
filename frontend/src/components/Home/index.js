import Banner from "components/Banner";
import '../Home/index.scss';
import Products from '../Products/index';
function Home() {
    return (
        <div className="body">
            <Banner />
            <Products />
        </div>
    );
}
export default Home;