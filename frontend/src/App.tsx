import Header from "./components/Header";
import CardVendas from "./components/CardVendas";

/**Declaração de função do javascript */
function App() {
  /**O nome disso '<></>' é fragmated */
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <CardVendas />
          </div>
        </section>
      </main>
    </>
  )
}

export default App;
